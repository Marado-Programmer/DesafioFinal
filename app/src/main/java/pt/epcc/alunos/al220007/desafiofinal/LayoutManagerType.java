package pt.epcc.alunos.al220007.desafiofinal;

public enum LayoutManagerType {
	LINEAR(0),
	GRID(1);

	public final int id;

	LayoutManagerType(int i) {
		this.id = i;
	}

	public static LayoutManagerType fromID(int i) {
		try {
			return LayoutManagerType.values()[i];
		} catch (ArrayIndexOutOfBoundsException e) {
			return  LayoutManagerType.LINEAR;
		}
	}
}
