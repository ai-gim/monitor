# cat install.sh 
#!/bin/bash
install_dir=/usr/local/lib/gim
if [[ -e $install_dir ]];then
    rm -rf $install_dir/monitor
else
    mkdir -p $install_dir
fi
sed -n '1,/^exit 0$/!p' $0 >$install_dir/monitor.tar.gz

cd $install_dir
tar -xzvf monitor.tar.gz

if [[ -e /etc/gim ]];then
    rm -rf /etc/gim/db.conf
    rm -rf /etc/gim/monitor.conf
else
    mkdir /etc/gim
fi

cd $install_dir/monitor
cp conf/* /etc/gim
cp init.d/gim-monitor /etc/rc.d/init.d

chmod 755 bin/*
chkconfig gim-monitor on

exit 0
