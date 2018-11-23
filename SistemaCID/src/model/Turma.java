package model;

public class Turma {
	private int id;
	private String turma;
	private String hora1;
	private String hora2;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getHora1() {
		return hora1;
	}
	public void setHora1(String hora1) {
		this.hora1 = hora1;
	}
	public String getHora2() {
		return hora2;
	}
	public void setHora2(String hora2) {
		this.hora2 = hora2;
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Turma: ");
        stringBuffer.append(this.turma);
        stringBuffer.append("Hora: ");
        stringBuffer.append(this.hora1);
        stringBuffer.append("Hora: ");
        stringBuffer.append(this.hora2);
		
		return stringBuffer.toString();
	}
	
}
