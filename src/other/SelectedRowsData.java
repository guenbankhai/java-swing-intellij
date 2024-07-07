package other;

public class SelectedRowsData {
    private int rowCount;
    private Object[][] data;

    public SelectedRowsData(int rowCount, Object[][] data) {
        this.rowCount = rowCount;
        this.data = data;
    }

    public int getRowCount() {
        return rowCount;
    }

    public Object[][] getData() {
        return data;
    }
}
