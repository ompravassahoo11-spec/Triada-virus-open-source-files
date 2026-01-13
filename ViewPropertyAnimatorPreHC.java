package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
class ViewPropertyAnimatorPreHC extends ViewPropertyAnimator {
    private static final int ALPHA = 512;
    private static final int NONE = 0;
    private static final int ROTATION = 16;
    private static final int ROTATION_X = 32;
    private static final int ROTATION_Y = 64;
    private static final int SCALE_X = 4;
    private static final int SCALE_Y = 8;
    private static final int TRANSFORM_MASK = 511;
    private static final int TRANSLATION_X = 1;
    private static final int TRANSLATION_Y = 2;
    private static final int X = 128;
    private static final int Y = 256;
    private long mDuration;
    private Interpolator mInterpolator;
    private final AnimatorProxy mProxy;
    private final WeakReference mView;
    private boolean mDurationSet = false;
    private long mStartDelay = 0;
    private boolean mStartDelaySet = false;
    private boolean mInterpolatorSet = false;
    private Animator.AnimatorListener mListener = null;
    private AnimatorEventListener mAnimatorEventListener = new AnimatorEventListener(this, null);
    ArrayList mPendingAnimations = new ArrayList();
    private Runnable mAnimationStarter = new Runnable() { // from class: com.nineoldandroids.view.ViewPropertyAnimatorPreHC.1
        @Override // java.lang.Runnable
        public void run() {
            ViewPropertyAnimatorPreHC.this.startAnimation();
        }
    };
    private HashMap mAnimatorMap = new HashMap();

    class AnimatorEventListener implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        private AnimatorEventListener() {
        }

        /* synthetic */ AnimatorEventListener(ViewPropertyAnimatorPreHC viewPropertyAnimatorPreHC, AnimatorEventListener animatorEventListener) {
            this();
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationCancel(animator);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationEnd(animator);
            }
            ViewPropertyAnimatorPreHC.this.mAnimatorMap.remove(animator);
            if (ViewPropertyAnimatorPreHC.this.mAnimatorMap.isEmpty()) {
                ViewPropertyAnimatorPreHC.this.mListener = null;
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationRepeat(animator);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationStart(animator);
            }
        }

        @Override // com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view;
            float animatedFraction = valueAnimator.getAnimatedFraction();
            PropertyBundle propertyBundle = (PropertyBundle) ViewPropertyAnimatorPreHC.this.mAnimatorMap.get(valueAnimator);
            if ((propertyBundle.mPropertyMask & ViewPropertyAnimatorPreHC.TRANSFORM_MASK) != 0 && (view = (View) ViewPropertyAnimatorPreHC.this.mView.get()) != null) {
                view.invalidate();
            }
            ArrayList arrayList = propertyBundle.mNameValuesHolder;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    NameValuesHolder nameValuesHolder = (NameValuesHolder) arrayList.get(i);
                    ViewPropertyAnimatorPreHC.this.setValue(nameValuesHolder.mNameConstant, nameValuesHolder.mFromValue + (nameValuesHolder.mDeltaValue * animatedFraction));
                }
            }
            View view2 = (View) ViewPropertyAnimatorPreHC.this.mView.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }

    class NameValuesHolder {
        float mDeltaValue;
        float mFromValue;
        int mNameConstant;

        NameValuesHolder(int i, float f, float f2) {
            this.mNameConstant = i;
            this.mFromValue = f;
            this.mDeltaValue = f2;
        }
    }

    class PropertyBundle {
        ArrayList mNameValuesHolder;
        int mPropertyMask;

        PropertyBundle(int i, ArrayList arrayList) {
            this.mPropertyMask = i;
            this.mNameValuesHolder = arrayList;
        }

        boolean cancel(int i) {
            if ((this.mPropertyMask & i) != 0 && this.mNameValuesHolder != null) {
                int size = this.mNameValuesHolder.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (((NameValuesHolder) this.mNameValuesHolder.get(i2)).mNameConstant == i) {
                        this.mNameValuesHolder.remove(i2);
                        this.mPropertyMask &= i ^ (-1);
                        return true;
                    }
                }
            }
            return false;
        }
    }

    ViewPropertyAnimatorPreHC(View view) {
        this.mView = new WeakReference(view);
        this.mProxy = AnimatorProxy.wrap(view);
    }

    private void animateProperty(int i, float f) {
        float value = getValue(i);
        animatePropertyBy(i, value, f - value);
    }

    private void animatePropertyBy(int i, float f) {
        animatePropertyBy(i, getValue(i), f);
    }

    private void animatePropertyBy(int i, float f, float f2) {
        Animator animator;
        if (this.mAnimatorMap.size() > 0) {
            Iterator it = this.mAnimatorMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    animator = null;
                    break;
                }
                animator = (Animator) it.next();
                PropertyBundle propertyBundle = (PropertyBundle) this.mAnimatorMap.get(animator);
                if (propertyBundle.cancel(i) && propertyBundle.mPropertyMask == 0) {
                    break;
                }
            }
            if (animator != null) {
                animator.cancel();
            }
        }
        this.mPendingAnimations.add(new NameValuesHolder(i, f, f2));
        View view = (View) this.mView.get();
        if (view != null) {
            view.removeCallbacks(this.mAnimationStarter);
            view.post(this.mAnimationStarter);
        }
    }

    private float getValue(int i) {
        switch (i) {
            case 1:
                return this.mProxy.getTranslationX();
            case 2:
                return this.mProxy.getTranslationY();
            case 4:
                return this.mProxy.getScaleX();
            case 8:
                return this.mProxy.getScaleY();
            case ROTATION /* 16 */:
                return this.mProxy.getRotation();
            case ROTATION_X /* 32 */:
                return this.mProxy.getRotationX();
            case ROTATION_Y /* 64 */:
                return this.mProxy.getRotationY();
            case X /* 128 */:
                return this.mProxy.getX();
            case Y /* 256 */:
                return this.mProxy.getY();
            case ALPHA /* 512 */:
                return this.mProxy.getAlpha();
            default:
                return 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(int i, float f) {
        switch (i) {
            case 1:
                this.mProxy.setTranslationX(f);
                break;
            case 2:
                this.mProxy.setTranslationY(f);
                break;
            case 4:
                this.mProxy.setScaleX(f);
                break;
            case 8:
                this.mProxy.setScaleY(f);
                break;
            case ROTATION /* 16 */:
                this.mProxy.setRotation(f);
                break;
            case ROTATION_X /* 32 */:
                this.mProxy.setRotationX(f);
                break;
            case ROTATION_Y /* 64 */:
                this.mProxy.setRotationY(f);
                break;
            case X /* 128 */:
                this.mProxy.setX(f);
                break;
            case Y /* 256 */:
                this.mProxy.setY(f);
                break;
            case ALPHA /* 512 */:
                this.mProxy.setAlpha(f);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimation() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f);
        ArrayList arrayList = (ArrayList) this.mPendingAnimations.clone();
        this.mPendingAnimations.clear();
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i |= ((NameValuesHolder) arrayList.get(i2)).mNameConstant;
        }
        this.mAnimatorMap.put(valueAnimatorOfFloat, new PropertyBundle(i, arrayList));
        valueAnimatorOfFloat.addUpdateListener(this.mAnimatorEventListener);
        valueAnimatorOfFloat.addListener(this.mAnimatorEventListener);
        if (this.mStartDelaySet) {
            valueAnimatorOfFloat.setStartDelay(this.mStartDelay);
        }
        if (this.mDurationSet) {
            valueAnimatorOfFloat.setDuration(this.mDuration);
        }
        if (this.mInterpolatorSet) {
            valueAnimatorOfFloat.setInterpolator(this.mInterpolator);
        }
        valueAnimatorOfFloat.start();
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator alpha(float f) {
        animateProperty(ALPHA, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator alphaBy(float f) {
        animatePropertyBy(ALPHA, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public void cancel() {
        if (this.mAnimatorMap.size() > 0) {
            Iterator it = ((HashMap) this.mAnimatorMap.clone()).keySet().iterator();
            while (it.hasNext()) {
                ((Animator) it.next()).cancel();
            }
        }
        this.mPendingAnimations.clear();
        View view = (View) this.mView.get();
        if (view != null) {
            view.removeCallbacks(this.mAnimationStarter);
        }
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public long getDuration() {
        return this.mDurationSet ? this.mDuration : new ValueAnimator().getDuration();
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public long getStartDelay() {
        if (this.mStartDelaySet) {
            return this.mStartDelay;
        }
        return 0L;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotation(float f) {
        animateProperty(ROTATION, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationBy(float f) {
        animatePropertyBy(ROTATION, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationX(float f) {
        animateProperty(ROTATION_X, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationXBy(float f) {
        animatePropertyBy(ROTATION_X, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationY(float f) {
        animateProperty(ROTATION_Y, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationYBy(float f) {
        animatePropertyBy(ROTATION_Y, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleX(float f) {
        animateProperty(4, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleXBy(float f) {
        animatePropertyBy(4, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleY(float f) {
        animateProperty(8, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleYBy(float f) {
        animatePropertyBy(8, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setDuration(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.mDurationSet = true;
        this.mDuration = j;
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setInterpolator(Interpolator interpolator) {
        this.mInterpolatorSet = true;
        this.mInterpolator = interpolator;
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setListener(Animator.AnimatorListener animatorListener) {
        this.mListener = animatorListener;
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setStartDelay(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.mStartDelaySet = true;
        this.mStartDelay = j;
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public void start() {
        startAnimation();
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationX(float f) {
        animateProperty(1, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationXBy(float f) {
        animatePropertyBy(1, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationY(float f) {
        animateProperty(2, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationYBy(float f) {
        animatePropertyBy(2, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator x(float f) {
        animateProperty(X, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator xBy(float f) {
        animatePropertyBy(X, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator y(float f) {
        animateProperty(Y, f);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator yBy(float f) {
        animatePropertyBy(Y, f);
        return this;
    }
}
