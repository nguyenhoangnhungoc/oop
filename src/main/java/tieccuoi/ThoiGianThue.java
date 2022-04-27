package tieccuoi;

public enum ThoiGianThue {
    ST("Sáng thường"),
    CT("Chiều thường"),
    TT("Tối thường"),
    SCT("Sáng cuối tuần"),
    CCT("Chiều cuối tuần"),
    TCT("Tối cuối tuần");
    public final String value;

    ThoiGianThue(String s) {
        this.value = s;
    }
}
