// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            HandlesEventDispatching

public interface Component
{

    public static final int ACCELEROMETER_SENSITIVITY_MODERATE = 2;
    public static final int ACCELEROMETER_SENSITIVITY_STRONG = 3;
    public static final int ACCELEROMETER_SENSITIVITY_WEAK = 1;
    public static final int ALIGNMENT_CENTER = 1;
    public static final int ALIGNMENT_NORMAL = 0;
    public static final int ALIGNMENT_OPPOSITE = 2;
    public static final String ASSET_DIRECTORY = "component";
    public static final int BUTTON_SHAPE_DEFAULT = 0;
    public static final int BUTTON_SHAPE_OVAL = 3;
    public static final int BUTTON_SHAPE_RECT = 2;
    public static final int BUTTON_SHAPE_ROUNDED = 1;
    public static final int COLOR_BLACK = 0xff000000;
    public static final int COLOR_BLUE = 0xff0000ff;
    public static final int COLOR_CYAN = 0xff00ffff;
    public static final int COLOR_DEFAULT = 0;
    public static final int COLOR_DKGRAY = 0xff444444;
    public static final int COLOR_GRAY = 0xff888888;
    public static final int COLOR_GREEN = 0xff00ff00;
    public static final int COLOR_LTGRAY = 0xffcccccc;
    public static final int COLOR_MAGENTA = -65281;
    public static final int COLOR_NONE = 0xffffff;
    public static final int COLOR_ORANGE = -14336;
    public static final int COLOR_PINK = -20561;
    public static final int COLOR_RED = 0xffff0000;
    public static final int COLOR_WHITE = -1;
    public static final int COLOR_YELLOW = -256;
    public static final String DEFAULT_VALUE_COLOR_BLACK = "&HFF000000";
    public static final String DEFAULT_VALUE_COLOR_BLUE = "&HFF0000FF";
    public static final String DEFAULT_VALUE_COLOR_CYAN = "&HFF00FFFF";
    public static final String DEFAULT_VALUE_COLOR_DEFAULT = "&H00000000";
    public static final String DEFAULT_VALUE_COLOR_DKGRAY = "&HFF444444";
    public static final String DEFAULT_VALUE_COLOR_GRAY = "&HFF888888";
    public static final String DEFAULT_VALUE_COLOR_GREEN = "&HFF00FF00";
    public static final String DEFAULT_VALUE_COLOR_LTGRAY = "&HFFCCCCCC";
    public static final String DEFAULT_VALUE_COLOR_MAGENTA = "&HFFFF00FF";
    public static final String DEFAULT_VALUE_COLOR_NONE = "&H00FFFFFF";
    public static final String DEFAULT_VALUE_COLOR_ORANGE = "&HFFFFC800";
    public static final String DEFAULT_VALUE_COLOR_PINK = "&HFFFFAFAF";
    public static final String DEFAULT_VALUE_COLOR_RED = "&HFFFF0000";
    public static final String DEFAULT_VALUE_COLOR_WHITE = "&HFFFFFFFF";
    public static final String DEFAULT_VALUE_COLOR_YELLOW = "&HFFFFFF00";
    public static final int DIRECTION_EAST = 3;
    public static final int DIRECTION_MAX = 4;
    public static final int DIRECTION_MIN = -4;
    public static final int DIRECTION_NONE = 0;
    public static final int DIRECTION_NORTH = 1;
    public static final int DIRECTION_NORTHEAST = 2;
    public static final int DIRECTION_NORTHWEST = -4;
    public static final int DIRECTION_SOUTH = -1;
    public static final int DIRECTION_SOUTHEAST = 4;
    public static final int DIRECTION_SOUTHWEST = -2;
    public static final int DIRECTION_WEST = -3;
    public static final float FONT_DEFAULT_SIZE = 14F;
    public static final int LAYOUT_ORIENTATION_HORIZONTAL = 0;
    public static final int LAYOUT_ORIENTATION_VERTICAL = 1;
    public static final int LENGTH_FILL_PARENT = -2;
    public static final int LENGTH_PREFERRED = -1;
    public static final int LENGTH_UNKNOWN = -3;
    public static final float SLIDER_MAX_VALUE = 50F;
    public static final float SLIDER_MIN_VALUE = 10F;
    public static final float SLIDER_THUMB_VALUE = 30F;
    public static final int TOAST_LENGTH_LONG = 1;
    public static final int TOAST_LENGTH_SHORT = 0;
    public static final int TYPEFACE_DEFAULT = 0;
    public static final int TYPEFACE_MONOSPACE = 3;
    public static final int TYPEFACE_SANSSERIF = 1;
    public static final int TYPEFACE_SERIF = 2;

    public abstract HandlesEventDispatching getDispatchDelegate();
}
