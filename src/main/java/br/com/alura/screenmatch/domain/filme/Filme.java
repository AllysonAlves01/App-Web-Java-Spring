package br.com.alura.screenmatch.domain.filme;

public class Filme {
    private String nome;
    private Integer duracaoemMinutos;
    private Integer anoLancamento;
    private String genero;

    public Filme(DadosCadastroFilme dados){
        this.nome = dados.nome();
        this.duracaoemMinutos = dados.duracao();
        this.anoLancamento = dados.ano();
        this.genero = dados.genero();

    }

    public String getNome() {
        return nome;
    }

    public Integer getDuracaoemMinutos() {
        return duracaoemMinutos;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", duracaoemMinutos=" + duracaoemMinutos +
                ", anoLancamento=" + anoLancamento +
                ", genero='" + genero + '\'' +
                '}';
    }
}
