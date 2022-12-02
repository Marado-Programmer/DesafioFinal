package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

public class DetailsFragment extends Fragment {
	public static final int DETAILS_ID = R.id.details;

	public static final String ID_KEY = "id";
	public static final String EXTRA_KEY = "extra";
	public static final String HUMAN_KEY = "human";

	private static final int LAYOUT = R.layout.human_id_layout;

	protected ViewStub include;

	protected ImageView profilePic;
	protected TextView name;

	protected int id;
	protected int extra;

	protected DetailsManager manager;

	public DetailsFragment() {
		super();
	}

	public DetailsFragment(DetailsManager manager, Bundle bundle) {
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

		id = args.getInt(ID_KEY, RecyclerView.NO_POSITION);
		extra = args.getInt(EXTRA_KEY, 0);
	}

	@Nullable
	@Override
	public View onCreateView(
		@NonNull LayoutInflater inflater,
		@Nullable ViewGroup container,
		@Nullable Bundle savedInstanceState
	) {
		return inflater.inflate(LAYOUT, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		if (manager == null) {
			return;
		}

		Bundle args = getArguments();

		if (args != null) {
			args = args.getBundle(HUMAN_KEY);
		}

		if (args == null) {
			return;
		}

		profilePic = view.findViewById(R.id.profile_pic);
		profilePic.setImageResource(args.getInt(Human.IMAGE_KEY, 0));

		name = view.findViewById(R.id.name);
		name.setText(args.getString(Human.NAME_KEY));

		include = view.findViewById(R.id.card_view_extra);
		include.setLayoutResource(extra);

		manager.createDetails(include.inflate(), args);
	}
}
