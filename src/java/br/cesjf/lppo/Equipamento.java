
package br.cesjf.lppo;


public class Equipamento {
    private long id;
    private String serie;
    private String local;
    private String descricao;
    private int estado;
    
    public Equipamento(){
    }

    
    public long getId() {
        return id;
    }

   
    public void setId(long id) {
        this.id = id;
    }

  
    public String getSerie() {
        return serie;
    }

   
    public void setSerie(String serie) {
        this.serie = serie;
    }

   
    public String getLocal() {
        return local;
    }

    
    public void setLocal(String local) {
        this.local = local;
    }

  
    public String getDescricao() {
        return descricao;
    }

   
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstado() {
        return estado;
    }

  
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
