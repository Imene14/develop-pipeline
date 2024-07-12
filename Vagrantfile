Vagrant.configure("2") do |config|
  config.vm.define "my-vm-name" do |vm|
    vm.vm.box = "hashicorp/bionic64"

    vm.vm.provider "virtualbox" do |vb|
      vb.memory = "1024"
      vb.cpus = 2
    end

    vm.vm.provision "shell", inline: <<-SHELL
      sudo apt-get update
      sudo apt-get install -y docker.io
      sudo systemctl start docker
      sudo systemctl enable docker
      sudo usermod -aG docker vagrant
    SHELL
  end
end


