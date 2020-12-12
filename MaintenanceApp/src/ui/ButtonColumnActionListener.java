package ui;

/**
 * Interface of the ButtonColumn action listener
 */
@FunctionalInterface
public interface ButtonColumnActionListener {
    /**
     * Fired when the used clicks one of the button in the column
     * @param rowIndex indicates the index row of the clicked button
     */
    public abstract void actionPerformed(int rowIndex);
}
