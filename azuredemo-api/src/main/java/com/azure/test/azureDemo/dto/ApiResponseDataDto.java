package com.azure.test.azureDemo.dto;

import java.util.Objects;

public class ApiResponseDataDto<T> extends ApiResponseDto {

    private T data;

    public ApiResponseDataDto() {
    }

    public ApiResponseDataDto(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiResponseDataDto<?> that = (ApiResponseDataDto<?>) o;
        return data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "ApiResponseDataDto{" +
                "data=" + data +
                '}';
    }
}
