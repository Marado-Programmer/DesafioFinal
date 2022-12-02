package pt.epcc.alunos.al220007.desafiofinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pt.epcc.alunos.al220007.desafiofinal.entities.SubjectModule;

public class ModulesAdapter extends RecyclerView.Adapter<ModulesAdapter.ViewHolder> {
	private final List<SubjectModule> modules;

	public ModulesAdapter(ArrayList<Integer> modulesKeys) {
		modules = modulesKeys.stream()
			.map(SubjectModule::getInstance)
			.collect(Collectors.toList());
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
			.inflate(R.layout.module_item, parent, false);

		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		holder.setModule(modules.get(position));
	}

	@Override
	public int getItemCount() {
		return modules.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		private final TextView name;
		private final TextView year;
		private final TextView duration;
		private final TextView curDuration;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);

			name = itemView.findViewById(R.id.moduleName);
			year = itemView.findViewById(R.id.moduleYear);
			duration = itemView.findViewById(R.id.moduleDuration);
			curDuration = itemView.findViewById(R.id.moduleCurrent);
		}

		public void setModule(SubjectModule module) {
			name.setText(module.getName());
			year.setText(String.valueOf(module.getYear()));
			duration.setText(module.getDurationString());
			curDuration.setText(module.getCurrentDurationString());
		}
	}
}
