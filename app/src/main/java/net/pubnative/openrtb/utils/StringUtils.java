package net.pubnative.openrtb.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    private static final String TAG = StringUtils.class.getSimpleName();

    private static Gson mGson;

    public static <T> List<T> convertStringToObjects(String convertable, Class<T> object) {
        List<T> result;
        if (mGson == null) {
            mGson = new Gson();
        }
        JsonArray array = new JsonParser().parse(convertable).getAsJsonArray();
        result = new ArrayList<T>(array.size());
        for (JsonElement element : array) {
            result.add(mGson.fromJson(element, object));
        }

        return result;
    }

    public static <T> T convertStringToObject(String convertable, Class<T> object) {
        T result;
        if (mGson == null) {
            mGson = new Gson();
        }
        JsonObject jsonObject = new JsonParser().parse(convertable).getAsJsonObject();
        result = mGson.fromJson(jsonObject, object);

        return result;
    }

    public static <T> String convertObjectsToJson(List<T> objects) {
        String result = null;
        Writer output = new StringWriter();
        if (mGson == null) {
            mGson = new Gson();
        }
        try {
            JsonWriter writer = new JsonWriter(output);
            writer.beginArray();
            for (T object : objects) {
                mGson.toJson(object, object.getClass(), writer);
            }
            writer.endArray();
            writer.close();

            output.flush();
            result = output.toString();

            output.close();
        } catch (IOException exception) {
            Log.e(TAG, "convertObjectsToJson: ", exception);
        }
        return result;
    }

    public static <T> String convertObjectToJson(T object) {
        String result = null;
        Writer output = new StringWriter();
        if (mGson == null) {
            mGson = new Gson();
        }
        try {
            JsonWriter writer = new JsonWriter(output);
            mGson.toJson(object, object.getClass(), writer);
            writer.close();

            output.flush();
            result = output.toString();

            output.close();
        } catch (IOException exception) {
            Log.e(TAG, "convertObjectToJson: ", exception);
        }
        return result;
    }
}
