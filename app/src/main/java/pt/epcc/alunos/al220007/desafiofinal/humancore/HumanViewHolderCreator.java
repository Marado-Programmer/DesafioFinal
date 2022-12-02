package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.view.View;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

public interface HumanViewHolderCreator<E extends Human, T extends ViewHolder<E, ? extends HumanDetailsActivity<E>>> {
	@NonNull
	T createViewHolder(View view, HumanActivity context);
}
