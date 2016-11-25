# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|

  config.vm.synced_folder "ammonite-configs", "/home/ubuntu/.ammonite"
  config.vm.synced_folder "emacs-config", "/home/ubuntu/.emacs.d"

  config.vm.define "workstation" do |sbt|
    sbt.vm.box = "ubuntu/xenial64"
    sbt.vm.network "forwarded_port", guest: 8000, host: 8000
    sbt.vm.network "forwarded_port", guest: 8000, host: 8080
  end

  config.vm.provision "ansible_local" do |ansible|
    ansible.playbook = "ansible_playbooks/playbook.yml"
    ansible.groups = {
      "workstations" => ["workstation"],
      "all_groups:children" => ["workstations"]
    }
  end

  # Provider-specific configuration so you can fine-tune various
  # backing providers for Vagrant. These expose provider-specific options.
  # Example for VirtualBox:
  #
  config.vm.provider "virtualbox" do |vb|
    # Customize the amount of memory on the VM:
    vb.memory = "4096"
    vb.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
  end

end
