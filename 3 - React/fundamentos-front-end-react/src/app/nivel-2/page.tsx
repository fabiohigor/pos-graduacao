import { ContadorGlobal } from "@/components/ContadorGlobal";
import { ValorContadorGlobal } from "@/components/ValorContadorGlobal";
import Link from "next/link";

const Page = () => (
    <div>
      <h1 className="text-4xl font-bold"> Página do nível 2</h1>
      <ContadorGlobal />
      <ValorContadorGlobal />
    </div>
);

export default Page;