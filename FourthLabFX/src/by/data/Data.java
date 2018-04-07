package by.data;

public class Data {
    private boolean isBusy = false;

    /**
     * This method displays data's availability
     * @return string available
     * @throws InterruptedException
     */
    public String iterract() throws InterruptedException{
        if (isBusy) throw new InterruptedException("Data is busy!");

        isBusy = true;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isBusy = false;
        return "Data is available now.";
    }
}
