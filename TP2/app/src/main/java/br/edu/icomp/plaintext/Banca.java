package br.edu.icomp.plaintext;

public class Banca {

    private String professor;
    private String defesa;
    private int id;


    Banca(int id, String professor, String defesa){
        this.professor = professor;
        this.defesa = defesa;
        this.id = id;

    }

    public String getProfessor(){
        return professor;
    }
    public void setProfessor(String professor){
        this.professor = professor;
    }

    public String getDefesa(){
        return defesa;
    }
    public void setDefesa(String defesa){
        this.defesa = defesa;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }




}
