package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pt.epcc.alunos.al220007.desafiofinal.R;

public class HumanDetailsFragment extends Fragment {
	protected ViewStub include;

	protected ImageView profilePic;
	protected TextView name;

	protected long id;
	protected int extra;

	public HumanDetailsFragment() {
		super();
	}

	public HumanDetailsFragment(Bundle bundle) {
		this();
		this.setArguments(bundle.getBundle("human"));
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (this.getArguments() == null) {
			return;
		}

		this.id = this.getArguments().getLong("id", 0);
		this.extra = this.getArguments().getInt("extra", 0);
	}

	@Nullable
	@Override
	public View onCreateView(
		@NonNull LayoutInflater inflater,
		@Nullable ViewGroup container,
		@Nullable Bundle savedInstanceState
	) {
		return inflater.inflate(R.layout.human_id_layout, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		this.include = view.findViewById(R.id.card_view_extra);
		this.include.setLayoutResource(this.extra);
		this.include.inflate();

		this.profilePic = view.findViewById(R.id.profile_pic);
		this.name = view.findViewById(R.id.name);
		this.findViews(view);
	}

	@Override
	public void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	protected void findViews(View view) {

	}
}
