package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

abstract public class HumanActivity<E extends Human, T extends HumanAdapter<? extends HumanViewHolder>> extends AppCompatActivity {
	protected RecyclerView recyclerView;
	protected T adapter;

	@Override
	protected void onCreate(/*@Nullable */@androidx.annotation.Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_human_list);

		this.recyclerView = this.findViewById(R.id.list);

		this.recyclerView.setLayoutManager(this.choseLayoutManager());

		this.adapter = (T) this.generateAdapterCreator().createAdapter(this.generateList(), this);
	}

	protected RecyclerView.LayoutManager choseLayoutManager() {
		return new LinearLayoutManager(this);
	}

	abstract protected HumanAdapterCreator<T> generateAdapterCreator();

	abstract protected List<E> generateList();
}
