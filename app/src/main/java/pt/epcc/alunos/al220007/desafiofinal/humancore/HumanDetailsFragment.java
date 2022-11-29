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
import pt.epcc.alunos.al220007.desafiofinal.entities.Bundable;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

public class HumanDetailsFragment<E extends Human> extends Fragment {
	protected ViewStub include;

	protected ImageView profilePic;
	protected TextView name;

	protected long id;
	protected int extra;

	protected DetailsManager manager;

	public HumanDetailsFragment() {
		super();
	}

	public HumanDetailsFragment(DetailsManager manager, Bundle bundle) {
		this();

		this.manager = manager;
		setArguments(bundle);
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle args = getArguments();

		if (args == null) {
			return;
		}

		id = args.getLong("id", 0);
		extra = args.getInt("extra", 0);
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

		if (manager == null) {
			return;
		}

		Bundle args = getArguments().getBundle("human");

		profilePic = view.findViewById(R.id.profile_pic);
		profilePic.setImageResource(args.getInt(Human.IMAGE_KEY, 0));

		name = view.findViewById(R.id.name);
		name.setText(args.getString(Human.NAME_KEY));

		include = view.findViewById(R.id.card_view_extra);
		include.setLayoutResource(extra);

		manager.createDetails(include.inflate(), args);
	}
}
