// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

public class TranslationContainer
{

    private Map CompTransMap;

    public TranslationContainer()
    {
        CompTransMap = new HashMap();
        CompTransMap.put("Basic", "\u57FA\u672C");
        CompTransMap.put("Media", "\u5A92\u4F53");
        CompTransMap.put("Animation", "\u52A8\u753B");
        CompTransMap.put("Social", "\u793E\u4EA4\u7684");
        CompTransMap.put("Sensors", "\u4F20\u611F\u5668");
        CompTransMap.put("Screen Arrangement", "\u5C4F\u5E55\u5E03\u5C40");
        CompTransMap.put("LEGO\256 MINDSTORMS\256", "\u4E50\u9AD8\u673A\u5668\u4EBA\u5957\u4EF6\256");
        CompTransMap.put("Other stuff", "\u5176\u4ED6\u4E1C\u897F");
        CompTransMap.put("Not ready for prime time", "\u6D4B\u8BD5\u4E2D\u7684\u5957\u4EF6");
        CompTransMap.put("Old stuff", "\u65E7\u4E1C\u897F");
        CompTransMap.put("Button", "\u6309\u94AE");
        CompTransMap.put("Canvas", "\u753B\u5E03");
        CompTransMap.put("CheckBox", "\u590D\u9009\u6846");
        CompTransMap.put("Clock", "\u65F6\u949F");
        CompTransMap.put("Image", "\u56FE\u50CF");
        CompTransMap.put("Label", "\u4FBF\u7B7E");
        CompTransMap.put("ListPicker", "\u5217\u8868\u9009\u62E9\u5668");
        CompTransMap.put("PasswordTextBox", "\u5BC6\u7801\u6846");
        CompTransMap.put("TextBox", "\u6587\u672C\u6846");
        CompTransMap.put("TinyDB", "\u7EC6\u5C0F\u6570\u636E\u5E93");
        CompTransMap.put("Camcorder", "\u6444\u50CF\u673A");
        CompTransMap.put("Camera", "\u76F8\u673A");
        CompTransMap.put("ImagePicker", "\u753B\u50CF\u9009\u62E9\u5668");
        CompTransMap.put("Player", "\u64AD\u653E\u5668");
        CompTransMap.put("Sound", "\u58F0\u97F3");
        CompTransMap.put("VideoPlayer", "\u5A92\u4F53\u64AD\u653E\u5668");
        CompTransMap.put("Ball", "\u7403");
        CompTransMap.put("ImageSprite", "\u56FE\u7247\u7CBE\u7075");
        CompTransMap.put("ContactPicker", "\u8054\u7CFB\u4FE1\u606F\u9009\u62E9\u5668");
        CompTransMap.put("EmailPicker", "\u90AE\u4EF6\u9009\u62E9\u5668");
        CompTransMap.put("PhoneCall", "\u7535\u8BDD");
        CompTransMap.put("PhoneNumberPicker", "\u7535\u8BDD\u53F7\u7801\u9009\u62E9\u5668");
        CompTransMap.put("Texting", "\u4FE1\u606F");
        CompTransMap.put("Twitter", "Twitter");
        CompTransMap.put("AccelerometerSensor", "\u52A0\u901F\u5EA6\u4F20\u611F\u5668");
        CompTransMap.put("LocationSensor", "\u4F4D\u7F6E\u4F20\u611F\u5668");
        CompTransMap.put("OrientationSensor", "\u65B9\u5411\u4F20\u611F\u5668");
        CompTransMap.put("HorizontalArrangement", "\u6C34\u5E73\u6392\u5217");
        CompTransMap.put("TableArrangement", "\u8868\u5B89\u6392");
        CompTransMap.put("VerticalArrangement", "\u7AD6\u5411\u5E03\u7F6E");
        CompTransMap.put("NxtColorSensor", "Nxt\u989C\u8272\u4F20\u611F\u5668");
        CompTransMap.put("NxtDirectCommands", "Nxt\u76F4\u63A5\u547D\u4EE4");
        CompTransMap.put("NxtDrive", "Nxt\u9A71\u52A8");
        CompTransMap.put("NxtLightSensor", "Nxt\u5149\u4F20\u611F\u5668");
        CompTransMap.put("NxtSoundSensor", "Nxt\u58F0\u97F3\u4F20\u611F\u5668");
        CompTransMap.put("NxtTouchSensor", "Nxt\u89E6\u6478\u4F20\u611F\u5668");
        CompTransMap.put("NxtUltrasonicSensor", "Nxt\u8D85\u58F0\u6CE2\u4F20\u611F\u5668");
        CompTransMap.put("ActivityStarter", "\u6D3B\u52A8\u542F\u52A8");
        CompTransMap.put("BarcodeScanner", "\u6761\u7801\u626B\u63CF\u5668");
        CompTransMap.put("BluetoothClient", "\u84DD\u7259\u5BA2\u6237");
        CompTransMap.put("BluetoothServer", "\u84DD\u7259\u670D\u52A1\u5668");
        CompTransMap.put("Notifier", "\u901A\u544A\u4EBA");
        CompTransMap.put("SpeechRecognizer", "\u8BED\u97F3\u8BC6\u522B");
        CompTransMap.put("TextToSpeech", "\u6587\u672C\u5230\u8BED\u97F3");
        CompTransMap.put("TinyWebDB", "\u7EC6\u5C0F\u7F51\u7EDC\u6570\u636E\u5E93");
        CompTransMap.put("Web", "\u7F51\u7EDC");
        CompTransMap.put("FusiontablesControl", "Fusiontables\u63A7\u5236");
        CompTransMap.put("GameClient", "\u6E38\u620F\u5BA2\u6237\u7AEF");
        CompTransMap.put("SoundRecorder", "\u58F0\u97F3\u8BB0\u5F55\u5668");
        CompTransMap.put("Voting", "\u6295\u7968");
        CompTransMap.put("WebViewer", "\u7F51\u9875\u6D4F\u89C8\u5668");
    }

    public String getCorrespondingString(String s)
    {
        if (CompTransMap.containsKey(s))
        {
            return (String)CompTransMap.get(s);
        } else
        {
            return "Missing name";
        }
    }
}
