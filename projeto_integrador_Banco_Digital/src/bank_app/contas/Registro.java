package bank_app.contas;

import java.time.LocalDateTime;

public class Registro {
    private Double valor;
    private LocalDateTime data;
    private String tipoTransacao;

    public Registro(Double valor, LocalDateTime data, String tipoTransacao) {
        this.setValor(valor);
        this.setData(data.withNano(0));
        this.setTipoTransacao(tipoTransacao);
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
}
