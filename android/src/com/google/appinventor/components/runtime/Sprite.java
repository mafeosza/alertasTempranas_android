// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.graphics.Canvas;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import com.google.appinventor.components.runtime.errors.AssertionFailure;
import com.google.appinventor.components.runtime.errors.IllegalArgumentError;
import com.google.appinventor.components.runtime.util.BoundingBox;
import com.google.appinventor.components.runtime.util.TimerInternal;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.appinventor.components.runtime:
//            VisibleComponent, AlarmHandler, OnDestroyListener, Deleteable, 
//            Canvas, ComponentContainer, Form, HandlesEventDispatching, 
//            EventDispatcher

public abstract class Sprite extends VisibleComponent
    implements AlarmHandler, OnDestroyListener, Deleteable
{

    private static final boolean DEFAULT_ENABLED = true;
    private static final int DEFAULT_HEADING = 0;
    private static final int DEFAULT_INTERVAL = 100;
    private static final float DEFAULT_SPEED = 0F;
    private static final boolean DEFAULT_VISIBLE = true;
    private static final double DEFAULT_Z = 1D;
    private static final String LOG_TAG = "Sprite";
    private final Handler androidUIHandler;
    protected final com.google.appinventor.components.runtime.Canvas canvas;
    protected double heading;
    protected double headingCos;
    protected double headingRadians;
    protected double headingSin;
    protected boolean initialized;
    protected int interval;
    private final Set registeredCollisions;
    protected float speed;
    private final TimerInternal timerInternal;
    protected double userHeading;
    protected boolean visible;
    protected double xLeft;
    protected double yTop;
    protected double zLayer;

    protected Sprite(ComponentContainer componentcontainer)
    {
        this(componentcontainer, new Handler());
    }

    protected Sprite(ComponentContainer componentcontainer, Handler handler)
    {
        initialized = false;
        visible = true;
        androidUIHandler = handler;
        if (!(componentcontainer instanceof com.google.appinventor.components.runtime.Canvas))
        {
            throw new IllegalArgumentError((new StringBuilder()).append("Sprite constructor called with container ").append(componentcontainer).toString());
        } else
        {
            canvas = (com.google.appinventor.components.runtime.Canvas)componentcontainer;
            canvas.addSprite(this);
            registeredCollisions = new HashSet();
            timerInternal = new TimerInternal(this, true, 100, handler);
            Heading(0.0D);
            Enabled(true);
            Interval(100);
            Speed(0.0F);
            Visible(true);
            Z(1.0D);
            componentcontainer.$form().registerForOnDestroy(this);
            return;
        }
    }

    public static boolean colliding(Sprite sprite, Sprite sprite1)
    {
        BoundingBox boundingbox = sprite.getBoundingBox(1);
        if (boundingbox.intersectDestructively(sprite1.getBoundingBox(1)))
        {
            double d = boundingbox.getLeft();
            while (d <= boundingbox.getRight()) 
            {
                for (double d1 = boundingbox.getTop(); d1 <= boundingbox.getBottom(); d1++)
                {
                    if (sprite.containsPoint(d, d1) && sprite1.containsPoint(d, d1))
                    {
                        return true;
                    }
                }

                d++;
            }
        }
        return false;
    }

    private final boolean overEastEdge(int i)
    {
        return xLeft + (double)Width() > (double)i;
    }

    private final boolean overNorthEdge()
    {
        return yTop < 0.0D;
    }

    private final boolean overSouthEdge(int i)
    {
        return yTop + (double)Height() > (double)i;
    }

    private final boolean overWestEdge()
    {
        return xLeft < 0.0D;
    }

    public void Bounce(int i)
    {
        MoveIntoBounds();
        double d1 = userHeading % 360D;
        double d = d1;
        if (d1 < 0.0D)
        {
            d = d1 + 360D;
        }
        if (i == 3 && (d < 90D || d > 270D) || i == -3 && d > 90D && d < 270D)
        {
            Heading(180D - d);
        } else
        {
            if (i == 1 && d > 0.0D && d < 180D || i == -1 && d > 180D)
            {
                Heading(360D - d);
                return;
            }
            if (i == 2 && d > 0.0D && d < 90D || i == -4 && d > 90D && d < 180D || i == -2 && d > 180D && d < 270D || i == 4 && d > 270D)
            {
                Heading(180D + d);
                return;
            }
        }
    }

    public void CollidedWith(Sprite sprite)
    {
        if (registeredCollisions.contains(sprite))
        {
            Log.e("Sprite", (new StringBuilder()).append("Collision between sprites ").append(this).append(" and ").append(sprite).append(" re-registered").toString());
            return;
        } else
        {
            registeredCollisions.add(sprite);
            postEvent(this, "CollidedWith", new Object[] {
                sprite
            });
            return;
        }
    }

    public boolean CollidingWith(Sprite sprite)
    {
        return registeredCollisions.contains(sprite);
    }

    public void Dragged(float f, float f1, float f2, float f3, float f4, float f5)
    {
        postEvent(this, "Dragged", new Object[] {
            Float.valueOf(f), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)
        });
    }

    public void EdgeReached(int i)
    {
        if (i == 0 || i < -4 || i > 4)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal argument ").append(i).append(" to Sprite.EdgeReached()").toString());
        } else
        {
            postEvent(this, "EdgeReached", new Object[] {
                Integer.valueOf(i)
            });
            return;
        }
    }

    public void Enabled(boolean flag)
    {
        timerInternal.Enabled(flag);
    }

    public boolean Enabled()
    {
        return timerInternal.Enabled();
    }

    public void Flung(float f, float f1, float f2, float f3, float f4, float f5)
    {
        postEvent(this, "Flung", new Object[] {
            Float.valueOf(f), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)
        });
    }

    public double Heading()
    {
        return userHeading;
    }

    public void Heading(double d)
    {
        userHeading = d;
        heading = -d;
        headingRadians = Math.toRadians(heading);
        headingCos = Math.cos(headingRadians);
        headingSin = Math.sin(headingRadians);
        registerChange();
    }

    public void Initialize()
    {
        initialized = true;
        canvas.registerChange(this);
    }

    public int Interval()
    {
        return timerInternal.Interval();
    }

    public void Interval(int i)
    {
        timerInternal.Interval(i);
    }

    public void MoveIntoBounds()
    {
        moveIntoBounds(canvas.Width(), canvas.Height());
    }

    public void MoveTo(double d, double d1)
    {
        xLeft = d;
        yTop = d1;
        registerChange();
    }

    public void NoLongerCollidingWith(Sprite sprite)
    {
        if (!registeredCollisions.contains(sprite))
        {
            Log.e("Sprite", (new StringBuilder()).append("Collision between sprites ").append(this).append(" and ").append(sprite).append(" removed but not present").toString());
        }
        registeredCollisions.remove(sprite);
        postEvent(this, "NoLongerCollidingWith", new Object[] {
            sprite
        });
    }

    public void PointInDirection(double d, double d1)
    {
        Heading(-Math.toDegrees(Math.atan2(d1 - Y() - (double)(Height() / 2), d - X() - (double)(Width() / 2))));
    }

    public void PointTowards(Sprite sprite)
    {
        Heading(-Math.toDegrees(Math.atan2((sprite.Y() - Y()) + (double)((sprite.Height() - Height()) / 2), (sprite.X() - X()) + (double)((sprite.Width() - Width()) / 2))));
    }

    public float Speed()
    {
        return speed;
    }

    public void Speed(float f)
    {
        speed = f;
    }

    public void TouchDown(float f, float f1)
    {
        postEvent(this, "TouchDown", new Object[] {
            Float.valueOf(f), Float.valueOf(f1)
        });
    }

    public void TouchUp(float f, float f1)
    {
        postEvent(this, "TouchUp", new Object[] {
            Float.valueOf(f), Float.valueOf(f1)
        });
    }

    public void Touched(float f, float f1)
    {
        postEvent(this, "Touched", new Object[] {
            Float.valueOf(f), Float.valueOf(f1)
        });
    }

    public void Visible(boolean flag)
    {
        visible = flag;
        registerChange();
    }

    public boolean Visible()
    {
        return visible;
    }

    public double X()
    {
        return xLeft;
    }

    public void X(double d)
    {
        xLeft = d;
        registerChange();
    }

    public double Y()
    {
        return yTop;
    }

    public void Y(double d)
    {
        yTop = d;
        registerChange();
    }

    public double Z()
    {
        return zLayer;
    }

    public void Z(double d)
    {
        zLayer = d;
        canvas.changeSpriteLayer(this);
    }

    public void alarm()
    {
        if (initialized && speed != 0.0F)
        {
            updateCoordinates();
            registerChange();
        }
    }

    public boolean containsPoint(double d, double d1)
    {
        return d >= xLeft && d < xLeft + (double)Width() && d1 >= yTop && d1 < yTop + (double)Height();
    }

    public BoundingBox getBoundingBox(int i)
    {
        return new BoundingBox(X() - (double)i, Y() - (double)i, ((X() + (double)Width()) - 1.0D) + (double)i, ((Y() + (double)Height()) - 1.0D) + (double)i);
    }

    public HandlesEventDispatching getDispatchDelegate()
    {
        return canvas.$form();
    }

    protected int hitEdge()
    {
        if (!canvas.ready())
        {
            return 0;
        } else
        {
            return hitEdge(canvas.Width(), canvas.Height());
        }
    }

    protected int hitEdge(int i, int j)
    {
        boolean flag = overWestEdge();
        boolean flag1 = overNorthEdge();
        boolean flag2 = overEastEdge(i);
        boolean flag3 = overSouthEdge(j);
        if (!flag1 && !flag3 && !flag2 && !flag)
        {
            return 0;
        }
        MoveIntoBounds();
        if (flag)
        {
            if (flag1)
            {
                return -4;
            }
            return !flag3 ? -3 : -2;
        }
        if (flag2)
        {
            if (flag1)
            {
                return 2;
            }
            return !flag3 ? 3 : 4;
        }
        if (flag1)
        {
            return 1;
        }
        if (flag3)
        {
            return -1;
        } else
        {
            throw new AssertionFailure("Unreachable code hit in Sprite.hitEdge()");
        }
    }

    public boolean intersectsWith(BoundingBox boundingbox)
    {
        BoundingBox boundingbox1 = getBoundingBox(0);
        if (boundingbox1.intersectDestructively(boundingbox))
        {
            double d = boundingbox1.getLeft();
            while (d < boundingbox1.getRight()) 
            {
                for (double d1 = boundingbox1.getTop(); d1 < boundingbox1.getBottom(); d1++)
                {
                    if (containsPoint(d, d1))
                    {
                        return true;
                    }
                }

                d++;
            }
        }
        return false;
    }

    protected final void moveIntoBounds(int i, int j)
    {
        boolean flag = false;
        if (Width() > i)
        {
            if (xLeft != 0.0D)
            {
                xLeft = 0.0D;
                flag = true;
            }
        } else
        if (overWestEdge())
        {
            xLeft = 0.0D;
            flag = true;
        } else
        if (overEastEdge(i))
        {
            xLeft = i - Width();
            flag = true;
        }
        if (Height() > j)
        {
            if (yTop != 0.0D)
            {
                yTop = 0.0D;
                flag = true;
            }
        } else
        if (overNorthEdge())
        {
            yTop = 0.0D;
            flag = true;
        } else
        if (overSouthEdge(j))
        {
            yTop = j - Height();
            flag = true;
        }
        if (flag)
        {
            registerChange();
        }
    }

    public void onDelete()
    {
        timerInternal.Enabled(false);
        canvas.removeSprite(this);
    }

    public void onDestroy()
    {
        timerInternal.Enabled(false);
    }

    protected abstract void onDraw(Canvas canvas1);

    protected transient void postEvent(final Sprite sprite, final String eventName, final Object args[])
    {
        androidUIHandler.post(new Runnable() {

            final Sprite this$0;
            final Object val$args[];
            final String val$eventName;
            final Sprite val$sprite;

            public void run()
            {
                EventDispatcher.dispatchEvent(sprite, eventName, args);
            }

            
            {
                this$0 = Sprite.this;
                sprite = sprite2;
                eventName = s;
                args = aobj;
                super();
            }
        });
    }

    protected void registerChange()
    {
        if (!initialized)
        {
            canvas.getView().invalidate();
            return;
        }
        int i = hitEdge();
        if (i != 0)
        {
            EdgeReached(i);
        }
        canvas.registerChange(this);
    }

    protected void updateCoordinates()
    {
        xLeft = xLeft + (double)speed * headingCos;
        yTop = yTop + (double)speed * headingSin;
    }
}
