package helper;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import dom.Rank;

public class GameTableLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		//
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		//
		Rank rank = (Rank) element;

		switch (columnIndex) {
		 case 0:
		 return Integer.toString(rank.getRank());
		case 1:
			return rank.getName();
		case 2:
			return Integer.toString(rank.getTime());
		case 3:
			return Integer.toString((rank.getCount()));
		default:
			return "unknown " + columnIndex;
		}

	}

}
