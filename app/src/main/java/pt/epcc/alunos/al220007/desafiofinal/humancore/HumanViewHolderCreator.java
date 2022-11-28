package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

public interface HumanViewHolderCreator<E extends Human, T extends HumanViewHolder<E>> {
	@NonNull
	T createViewHolder(View view, HumanActivity context);
}
