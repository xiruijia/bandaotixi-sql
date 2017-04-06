package cc.bandaotixi.tools.panal;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class ConnetcionList  extends JScrollPane{
	private static final long serialVersionUID = 1L;
	private JTree tree=new JTree(new DefaultMutableTreeNode("root"));
	public ConnetcionList() {
		super();
		add(tree);
		tree.setRootVisible(false);
		setVisible(true);
		setBackground(Color.RED);
		init();
	}
	public void init(){
		DefaultMutableTreeNode lx=(DefaultMutableTreeNode)tree. getModel().getRoot();
        DefaultMutableTreeNode qr=new DefaultMutableTreeNode("亲人");
        DefaultMutableTreeNode ba=new DefaultMutableTreeNode("爸爸");
        DefaultMutableTreeNode jj=new DefaultMutableTreeNode("姐姐");
        DefaultMutableTreeNode tx=new DefaultMutableTreeNode("同学");
        DefaultMutableTreeNode cy=new DefaultMutableTreeNode("程远");
        DefaultMutableTreeNode py=new DefaultMutableTreeNode("朋友");
        DefaultMutableTreeNode wz=new DefaultMutableTreeNode("武总");
        lx.add(qr);
        qr.add(ba);
        qr.add(jj);
        lx.add(tx);
        tx.add(cy);
        lx.add(py);
        py.add(wz);
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        lx.add(new DefaultMutableTreeNode("武总"));
        tree.expandPath(new TreePath(tree.getModel().getRoot()));
        tree.updateUI();
        updateUI();
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
                if(node==null) return;
                System.out.println(node.getUserObject());
            }
        });
	}
}
