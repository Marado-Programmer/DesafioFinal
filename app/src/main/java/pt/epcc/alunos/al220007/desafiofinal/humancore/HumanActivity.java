package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

abstract public class HumanActivity<E extends Human, T extends HumanAdapter<? extends HumanViewHolder>> extends AppCompatActivity {
	protected RecyclerView recyclerView;
	protected T adapter;

	@Override
	protected void onCreate(/*@Nullable */@androidx.annotation.Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_human_list);

		this.recyclerView = this.findViewById(R.id.list);

		this.recyclerView.setLayoutManager(this.choseLayoutManager());

		this.adapter = this.generateAdapterCreator().createAdapter(this.generateList(), this);

		this.recyclerView.setAdapter(this.adapter);
	}

	abstract protected RecyclerView.LayoutManager choseLayoutManager();

	abstract protected HumanAdapterCreator<T> generateAdapterCreator();

	abstract protected List<E> generateList();
}
