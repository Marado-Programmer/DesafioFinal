package pt.epcc.alunos.al220007.desafiofinal.humancore;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

public interface DetailsManager<E extends Human, T extends ExtraBuilder<E>> extends ExtraBuilderCreator<E, T> {
	void createDetails(T builder);

}
