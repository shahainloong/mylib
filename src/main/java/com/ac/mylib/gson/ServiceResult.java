package com.ac.mylib.gson;

import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * @author hailong.sha
 */
public class ServiceResult {

    private static final String RAW_STORE = "rawStore://";


    /** the response status from abap response */
    private final int status;
    /** the json representation of abap response structure */
    private final JsonElement json;
    /** additonal storage object for large byte arrays */
    private final List<byte[]> rawStore;
    /** the duration in ms the abap system call has needed */
    private long durationAbapCall = -1;
    /** the duration in ms the transformation of abap structure to json has needed */
    private long durationJsonTransformation = -1;
    /** the duration in ms the transformation of abap structure to json has needed */
    private int cacheMaxAge = -1;

    public ServiceResult (final int status, final JsonElement json, List<byte[]> rawStore) {
        this.status = status;
        this.json = json;
        this.rawStore = rawStore;
    }

    public int getStatus() {
        return status;
    }

    public JsonElement getJson() {
        return json;
    }

    public static String extractRawLink (final JsonObject content, final String propertyName) {
        if (content != null && content.has(propertyName)) {
            JsonElement fileContentRaw = content.get(propertyName);
            if (fileContentRaw != null && fileContentRaw.isJsonPrimitive()) {
                JsonPrimitive fileContentRawPrimitive = fileContentRaw.getAsJsonPrimitive();
                if (fileContentRawPrimitive != null && fileContentRawPrimitive.isString()) {
                    return fileContentRawPrimitive.getAsString();
                }
            }
        }
        return "";
    }

    public static boolean isRawLink(String link) {
        return link.startsWith(RAW_STORE);
    }

    public byte[] getRaw(String link) {
        int index = Integer.valueOf(link.substring(RAW_STORE.length()));
        return rawStore.get(index);
    }

    public static String createRawLink(int index) {
        return RAW_STORE + index;
    }

    public int getCacheMaxAge() {
        return cacheMaxAge;
    }

    public void setCacheMaxAge(int cacheMaxAge) {
        this.cacheMaxAge = cacheMaxAge;
    }

    public long getDurationAbapCall() {
        return durationAbapCall;
    }

    public void setDurationAbapCall(long durationAbapCall) {
        this.durationAbapCall = durationAbapCall;
    }

    public long getDurationJsonTransformation() {
        return durationJsonTransformation;
    }

    public void setDurationJsonTransformation(long durationJsonTransformation) {
        this.durationJsonTransformation = durationJsonTransformation;
    }

}
