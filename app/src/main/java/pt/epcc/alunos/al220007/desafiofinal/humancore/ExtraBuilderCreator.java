package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.os.Bundle;
import android.view.ViewStub;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

public interface ExtraBuilderCreator<E extends Human, T extends ExtraBuilder<E>> {
	T createBuilder(@NonNull ViewStub view, Bundle human);
}
