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
import androidx.recyclerview.widget.RecyclerView;

import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

@SuppressWarnings("FieldCanBeLocal")
public final class DetailsFragment<E extends Human, T extends ExtraBuilder<E>> extends Fragment {
	public static final int DETAILS_ID = R.id.details;
	public static final int IMAGE_ID = R.id.profile_pic;
	public static final int NAME_ID = R.id.name;
	public static final int EXTRA_ID = R.id.card_view_extra;

	public static final String ID_KEY = "id";
	public static final String EXTRA_KEY = "extra";
	public static final String HUMAN_KEY = "human";

	private static final int LAYOUT = R.layout.human_id_layout;

	private ViewStub include;

	private ImageView profilePic;
	private TextView name;

	private int id;
	private int extra;

	private DetailsManager<E, T> manager;

	public DetailsFragment() {
		super();
	}

	public DetailsFragment(@NonNull DetailsManager<E, T> manager, Bundle bundle) {
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

		putBasicDetails(view, args);

		manager.createDetails(manager.createBuilder(include, args));
	}

	private void putBasicDetails(@NonNull View view, @NonNull Bundle args) {
		profilePic = view.findViewById(IMAGE_ID);
		profilePic.setImageResource(args.getInt(Human.IMAGE_KEY, 0));

		name = view.findViewById(NAME_ID);
		name.setText(args.getString(Human.NAME_KEY));

		include = view.findViewById(EXTRA_ID);
		include.setLayoutResource(extra);
	}
}
