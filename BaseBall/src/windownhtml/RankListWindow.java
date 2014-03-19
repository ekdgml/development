package windownhtml;

import helper.GameTableLabelProvider;
import helper.RankDataHandler;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class RankListWindow {

	public static void show() {
		//
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(400, 400);
		shell.setText("Game Rank");
		shell.setLayout(new GridLayout());
		// ------------------------------------------------------
		Label titleLabel = new Label(shell, SWT.None);
		titleLabel.setText("Game Result");

		TableViewer tableViewer = new TableViewer(shell, SWT.SINGLE
				| SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		String[] columnNames = new String[] { "����", "�̸�", "�ɸ��ð�",
				"�õ�Ƚ��" };
		int[] columnWidths = new int[] { 100, 100, 100, 100 };
		int[] columnAlignments = new int[] { SWT.LEFT, SWT.LEFT, SWT.CENTER,
				SWT.CENTER };

		for (int i = 0; i < columnNames.length; i++) {
			TableColumn tableColumn = new TableColumn(table,
					columnAlignments[i]);
			tableColumn.setText(columnNames[i]);
			tableColumn.setWidth(columnWidths[i]);
		}

		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setLabelProvider(new GameTableLabelProvider());
		tableViewer.setInput(RankDataHandler.readCSV().toArray());

		// ------------------------------------------------------
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

	}

}
