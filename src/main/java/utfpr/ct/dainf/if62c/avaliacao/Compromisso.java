package utfpr.ct.dainf.if62c.avaliacao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author Daniel
 */
public class Compromisso {
    private Date data;
    private String descricao;
    private final List<Aviso> avisos = new ArrayList<>();
    
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    public Compromisso(Date data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Aviso> getAvisos() {
        return avisos;
    }
    
    public void registraAviso(Aviso aviso) {
        avisos.add(aviso);
    }
    
    @Override
    public String toString() {
        return dateFormat.format(data) + ": " + descricao;
    }

}
