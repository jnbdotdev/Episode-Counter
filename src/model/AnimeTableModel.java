package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class AnimeTableModel extends AbstractTableModel{
	
	private List<Anime> dados = new ArrayList<>();
	private String[] colunas = {"Código","Nome","Temporada", "Episódio"};
	
	public String getColumnName(int column) {
		return colunas[column];
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch(coluna) {
			case 0:
				return dados.get(linha).getCodigo();
			case 1:
				return dados.get(linha).getNome();
			case 2:
				return dados.get(linha).getTemporada();
			case 3:
				return dados.get(linha).getEpisodio();
		}
		return null;
	}
	public void setValueAt(Object valor, int linha, int coluna) {
		switch(coluna) {
		
		case 0:
			dados.get(linha).setCodigo((int) valor);
			break;
		case 1:
			dados.get(linha).setNome((String) valor);
			break;
		case 2:
			dados.get(linha).setTemporada((int) valor);
			break;
		case 3:
			dados.get(linha).setEpisodio((int) valor);
			break;
	}
		this.fireTableRowsUpdated(linha, linha);
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
