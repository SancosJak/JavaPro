package de.ait.worddemo.model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Word {

    private String value;
//    public Word(String value) {
//        this.value = value;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Word word = (Word) o;
//        return Objects.equals(value, word.value);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(value);
//    }
//
//    @Override
//    public String toString() {
//        return "Word{" +
//                "value='" + value + '\'' +
//                '}';
//    }
}

