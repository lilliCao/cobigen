package com.capgemini.cobigen.openapiplugin.model;

/**
 * TODO
 */
public class ResponseDef {

    private boolean isArray;

    private boolean isPaginated;

    private boolean isVoid;

    private String type;

    public ResponseDef() {
        isArray = false;
        isPaginated = false;
        isVoid = false;
    }

    public boolean getIsArray() {
        return isArray;
    }

    public void setIsArray(boolean isArray) {
        this.isArray = isArray;
    }

    public boolean getIsPaginated() {
        return isPaginated;
    }

    public void setIsPaginated(boolean isPaginated) {
        this.isPaginated = isPaginated;
    }

    public boolean getIsVoid() {
        return isVoid;
    }

    public void setIsVoid(boolean isVoid) {
        this.isVoid = isVoid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
