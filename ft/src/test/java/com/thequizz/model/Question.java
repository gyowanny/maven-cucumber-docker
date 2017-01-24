package com.thequizz.model;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String location;

    private String text;

    private List<Option> options = new ArrayList<>();

    public Question(String location, String text, List<Option> options) {
        this.location = location;
        this.text = text;
        this.options = options;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (location != null ? !location.equals(question.location) : question.location != null) return false;
        if (text != null ? !text.equals(question.text) : question.text != null) return false;
        return options != null ? options.equals(question.options) : question.options == null;

    }

    @Override
    public int hashCode() {
        int result = location != null ? location.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (options != null ? options.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "location='" + location + '\'' +
                ", text='" + text + '\'' +
                ", options=" + options +
                '}';
    }
}
