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

	protected HumanViewHolder holder;

	public HumanDetailsFragment(HumanViewHolder holder, Bundle bundle) {
		super();

		this.holder = holder;
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

		assert holder != null;

		profilePic = view.findViewById(R.id.profile_pic);
		profilePic.setImageResource(holder.profilePic());

		name = view.findViewById(R.id.name);
		name.setText(holder.name());

		include = view.findViewById(R.id.card_view_extra);
		include.setLayoutResource(extra);

		holder.findViews(include.inflate());
	}
}
