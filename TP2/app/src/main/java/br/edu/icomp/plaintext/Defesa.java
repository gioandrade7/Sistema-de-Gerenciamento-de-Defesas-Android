package br.edu.icomp.plaintext;


public class Defesa {

    private int id;
    private String aluno;
    private String tipo_de_defesa;
    private String titulo_da_defesa;
    private String dia;
    private String lugar;
    private String orientador;
    private String nota_final;
    private String observacoes;

    Defesa(int id, String aluno, String tipo_de_defesa, String titulo_da_defesa, String dia, String lugar, String orientador,
           String nota_final, String observacoes){
        this.id = id;
        this.aluno = aluno;
        this.dia = dia;
        this.lugar = lugar;
        this.nota_final = nota_final;
        this.observacoes = observacoes;
        this.orientador = orientador;
        this.tipo_de_defesa = tipo_de_defesa;
        this.titulo_da_defesa = titulo_da_defesa;
    }

    public String getAluno(){
        return aluno;
    }
    public void setAluno(String aluno){
        this.aluno = aluno;
    }

    public String getTipo_de_defesa(){
        return tipo_de_defesa;
    }
    public void setTipo_de_defesa(String tipo_de_defesa){
        this.tipo_de_defesa = tipo_de_defesa;
    }

    public String getTitulo_da_defesa(){
        return titulo_da_defesa;
    }
    public void setTitulo_da_defesa(String titulo_da_defesa){
        this.titulo_da_defesa = titulo_da_defesa;
    }

    public String getDia(){
        return dia;
    }
    public void setDia(String dia){
        this.dia = dia;
    }

    public String getLugar(){
        return lugar;
    }
    public void setLugar(String lugar){
        this.lugar = lugar;
    }

    public String getOrientador(){
        return orientador;
    }
    public void setOrientador(String orientador){
        this.orientador = orientador;
    }

    public String getObservacoes(){
        return observacoes;
    }

    public void setObservacoes(String observacoes){
        this.observacoes = observacoes;
    }

    public String getNota_final(){
        return nota_final;
    }
    public void setNota_final(String nota_final){
        this.nota_final = nota_final;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

}
