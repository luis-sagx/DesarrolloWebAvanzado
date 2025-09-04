package com.sagnay.luis.ex3.models.dto;

public class TiempoPromedioDto {
    private String categoria;
    private Double horasPromedio;

    public TiempoPromedioDto() {}

    public TiempoPromedioDto(String categoria, Double horasPromedio) {
        this.categoria = categoria;
        this.horasPromedio = horasPromedio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getHorasPromedio() {
        return horasPromedio;
    }

    public void setHorasPromedio(Double horasPromedio) {
        this.horasPromedio = horasPromedio;
    }
}
