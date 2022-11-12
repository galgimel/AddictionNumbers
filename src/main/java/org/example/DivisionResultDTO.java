package org.example;

import java.util.ArrayList;
import java.util.List;

public class DivisionResultDTO {

    private List<String> firstLineInt = new ArrayList<>();
    private List<String> secondLineInt = new ArrayList<>();
    private List<String> thirdLineInt = new ArrayList<>();
    private List<String> leftSpaces = new ArrayList<>();

    public List<String> getFirstLineInt() {
        return firstLineInt;
    }

    public void setFirstLineInt(List<String> firstLineInt) {
        this.firstLineInt = firstLineInt;
    }

    public List<String> getSecondLineInt() {
        return secondLineInt;
    }

    public void setSecondLineInt(List<String> secondLineInt) {
        this.secondLineInt = secondLineInt;
    }

    public List<String> getThirdLineInt() {
        return thirdLineInt;
    }

    public void setThirdLineInt(List<String> thirdLineInt) {
        this.thirdLineInt = thirdLineInt;
    }

    public List<String> getLeftSpaces() {
        return leftSpaces;
    }

    public void setLeftSpaces(List<String> leftSpaces) {
        this.leftSpaces = leftSpaces;
    }
}