package controller;

import javafx.scene.control.ListView;

/**
 * Base class for child controllers of the Coding Challenge app.
 */
public class SubController {

    protected CodingChallengeController parentController;

    protected ListView<String> outputListView;

    /**
     * Sets the parent controller.
     * @param parentController the parent controller
     */
    public void setParentController(CodingChallengeController parentController) {
        this.parentController = parentController;
    } // end method setParentController

    /**
     * Sets the list view for displaying generated sequence.
     * @param outputListView the list view
     */
    public void setOutputListView(ListView<String> outputListView) {
        this.outputListView = outputListView;
    } // end method setOutputListView

} // end class SubController
