package Lessons10;

import java.util.Objects;

public class TelefonBook {
    String fio;
    String number;

    public TelefonBook(String fio, String number) {
        this.fio = fio;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefonBook that = (TelefonBook) o;
        return fio.equals(that.fio) &&
                number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, number);
    }

//    @Override
    public int compareTo(TelefonBook o) {
        return 0;
    }

    @Override
    public String toString() {
        return "TelefonBook{" +
                "fio='" + fio + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
