package lee.study.down.gui;

import dorkbox.systemTray.Checkbox;

import java.awt.event.ActionListener;

public class CheckboxItem extends Checkbox {

  public CheckboxGroup group;

  public CheckboxItem() {
    this(null, null, null);
  }

  public CheckboxItem(String text) {
    this(text, null, null);
  }

  public CheckboxItem(String text, ActionListener callback) {
    this(text, callback, null);
  }

  public CheckboxItem(String text, CheckboxGroup group) {
    this(text, null, group);
  }

  public CheckboxItem(String text, ActionListener callback, CheckboxGroup group) {
    super(text, callback);
    this.group = group;
  }

  public void setCheckedInternal(boolean isChecked) {
    super.setChecked(isChecked);
  }

  public void setEnabledInternal(boolean enabled) {
    super.setEnabled(enabled);
  }

  @Override
  public void setChecked(boolean isChecked) {
    if (group != null) {
      if (isChecked) {
        group.setSelectedCheckbox(this);
      } else if (group.getSelectedCheckbox() == this) {
        isChecked = true;
      }
    }
    setCheckedInternal(isChecked);
  }

  @Override
  public void setEnabled(boolean enabled) {

  }
}