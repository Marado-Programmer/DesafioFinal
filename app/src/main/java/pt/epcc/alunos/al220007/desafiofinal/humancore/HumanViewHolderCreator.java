package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.view.View;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.DetailsActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public interface HumanViewHolderCreator<E extends Human, T extends ViewHolder<E, ? extends DetailsActivity<E>>> {
	@NonNull
	T createViewHolder(View view, HumanActivity context);
}
