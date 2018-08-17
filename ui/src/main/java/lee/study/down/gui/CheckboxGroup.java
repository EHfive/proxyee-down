package lee.study.down.gui;

public class CheckboxGroup {
  CheckboxItem selectedCheckbox = null;

  public synchronized void setSelectedCheckbox(CheckboxItem box) {
    if (box != null && box.group != this) {
      return;
    }
    CheckboxItem oldChoice = this.selectedCheckbox;
    this.selectedCheckbox = box;
    if (oldChoice != null && oldChoice != box && oldChoice.group == this) {
      oldChoice.setEnabledInternal(true);
      oldChoice.setChecked(false);
    }
    if (box != null && oldChoice != box && !box.getChecked()) {
      box.setCheckedInternal(true);
      box.setEnabledInternal(false);
    }
  }

  public CheckboxItem getSelectedCheckbox() {
    return selectedCheckbox;
  }
}
