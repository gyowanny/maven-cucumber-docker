package com.thequizz.model;

/**
 * Created by gqu04 on 19/01/2017.
 */
public class Option {

    private String text;

    public Option(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Option option = (Option) o;

        return text != null ? text.equals(option.text) : option.text == null;

    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Option{" +
                "text='" + text + '\'' +
                '}';
    }
}
