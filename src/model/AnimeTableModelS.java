package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AnimeTableModelS extends AbstractTableModel{
	
	private List<Anime> dados = new ArrayList<>();
	private ArrayList linhas = null;
	private String[] colunas = null;
	
	public AnimeTableModelS(ArrayList lin,String[] col) {
		setLinhas(lin);
		setColunas(col);
	}
	public ArrayList getLinhas() {
		return linhas;
	}
	public void setLinhas(ArrayList dados) {
		linhas=dados;
	}
	public String[] getColunas() {
		return colunas;
	}
	public void setColunas(String[] nomes) {
		colunas = nomes;
	}
	public int getColumnCount() {
		return colunas.length;
	}
	public int getRowCount() {
		return linhas.size();
	}
	public String getColumnName(int numCol) {
		return colunas[numCol];
	}
	public Object getValueAt(int numLin, int numCol) {
		Object[] linha = (Object[])getLinhas().get(numLin);
		return linha[numCol];
	}
	public void addRow(Anime a){
		this.dados.add(a);
		this.fireTableDataChanged();
	}
	public void removeRow(int linha) {
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}
}
	
