package br.com.zedrax.services.vo.unreal;

import java.util.List;

public class DataVo<T> {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}