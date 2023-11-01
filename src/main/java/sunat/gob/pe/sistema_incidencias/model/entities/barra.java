package sunat.gob.pe.sistema_incidencias.model.entities;

public class barra {
    private String Texto;
    private int valor;

    public barra(String Texto, int valor) {
        this.Texto = Texto;
        this.valor = valor;
    }

    
    
    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
